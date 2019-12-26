package WayofTime.alchemicalWizardry.integration;

import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import com.gamerforea.eventhelper.util.EventUtils;
import cpw.mods.fml.common.Loader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import javax.annotation.Nonnull;

public class ModHookEventHelper {

   public static boolean initialized = false;

   public static boolean isPresent(){
      return initialized;
   }

   public static void initialize() {
      initialized = Loader.isModLoaded(getModID());
      if(initialized) {
         AlchemicalWizardry.logger.info("EventHelper has been enabled on Avaritia!");
      }
   }

   public static String getModID() {
      return "EventHelper";
   }

   public static boolean cantBreak(@Nonnull EntityPlayer player, double x, double y, double z){
      if (initialized){
         return EventUtils.cantBreak(player,x,y,z);
      }
      return false;
   }

   public static boolean cantAttack(@Nonnull Entity attacker, @Nonnull Entity victim){
      if (initialized){
         return EventUtils.cantDamage(attacker,victim);
      }
      return false;
   }

   public static boolean hasPermission(@Nonnull EntityPlayer player, @Nonnull String permission){
      if (initialized){
         return EventUtils.hasPermission(player,permission);
      }
      return false;
   }

}
