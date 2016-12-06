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
package me.mrdoc.PickUpFlag.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 *
 * @author Doc
 */
public class GlobalEvents implements Listener {
    
    /**
     * Evento cuando se toma un item
     * @param event Evento
     */
    public void onPickFlag(PlayerPickupItemEvent event) {
        final Player player = event.getPlayer();
        final ItemStack item = event.getItem().getItemStack();
        if(item.getType().equals(Material.BANNER)) {
            //Datos del item en modo bandera
            BannerMeta metaBanner = (BannerMeta)item.getItemMeta();
            //Obtengo el color de la bandera
            DyeColor colorBanner = metaBanner.getBaseColor();
            
            //TODO: Colocar efecto glow.
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 999999, 1, true, true, colorBanner.getColor()), false);
            
            //Aviso
            //Bukkit.getScoreboardManager().getMainScoreboard().getTeams();
            
            Bukkit.broadcastMessage(ChatColor.GOLD + "[ANUNCIADOR]" + ChatColor.YELLOW + "Han robado la bandera del equipo " + colorBanner.name() + ChatColor.YELLOW + ".");
        }
        
    }
    
    /**
     * Evento cuando se dropea un item
     * @param event Evento
     */
    public void onDropFlag(PlayerDropItemEvent event) {
        final Player player = event.getPlayer();
        final ItemStack item = event.getItemDrop().getItemStack();
        if(item.getType().equals(Material.BANNER)) {
            //Datos del item en modo bandera
            BannerMeta metaBanner = (BannerMeta)item.getItemMeta();
            //Obtengo el color de la bandera
            DyeColor colorBanner = metaBanner.getBaseColor();
            
            //TODO: Colocar efecto glow.
            player.removePotionEffect(PotionEffectType.GLOWING);
            
            //Aviso
            //Bukkit.getScoreboardManager().getMainScoreboard().getTeams();
            if(player.isDead()) {
                Bukkit.broadcastMessage(ChatColor.GOLD + "[ANUNCIADOR]" + ChatColor.YELLOW + "Han dropeado la bandera del equipo " + colorBanner.name() + ChatColor.YELLOW + ".");
            }
        }
    }
    
}
