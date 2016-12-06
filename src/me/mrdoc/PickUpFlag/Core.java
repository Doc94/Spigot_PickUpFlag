/*
 * Copyright 2016 Doc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.mrdoc.PickUpFlag;

import java.util.logging.Level;
import me.mrdoc.PickUpFlag.Events.GlobalEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Doc
 */
public class Core extends JavaPlugin {
    
    private static Core INSTANCE;
    
    
    @Override
    public void onEnable() {
        //Carga de instancia
        INSTANCE = this;
        
        Bukkit.getServer().getPluginManager().registerEvents(new GlobalEvents(),this);
        
        getLogger().info("==================================================");
        getLogger().log(Level.INFO, "Plugin {0} Cargado...", getName());
        getLogger().info("==================================================");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("==================================================");
        getLogger().log(Level.INFO, "Plugin {0} Detenido...", getName());
        getLogger().info("==================================================");
    }
    
    public static Core getInstance() {
        return INSTANCE;
    }
}
