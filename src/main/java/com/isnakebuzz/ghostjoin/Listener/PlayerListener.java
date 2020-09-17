package com.isnakebuzz.ghostjoin.Listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Objects;

public class PlayerListener implements Listener {

    private Scoreboard sb;
    private Team team;


    public PlayerListener() {
        this.sb = Objects.requireNonNull(Bukkit.getScoreboardManager()).getNewScoreboard();
        this.team = sb.registerNewTeam("Ghost");
        this.team.setCanSeeFriendlyInvisibles(true);
    }


    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setScoreboard(sb);
        team.addPlayer(e.getPlayer());

        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 0, false, false));
    }

    @EventHandler
    public void PlayerLeave(PlayerQuitEvent e) {
        team.removePlayer(e.getPlayer());
    }

}
