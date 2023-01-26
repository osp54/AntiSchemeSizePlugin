package com.ospx.antischemesize;

import arc.Events;
import arc.util.Log;
import mindustry.game.EventType;
import mindustry.gen.Call;
import mindustry.mod.*;

import static mindustry.Vars.netServer;

public class Main extends Plugin{
    @Override
    public void init() {
        Events.on(EventType.PlayerJoin.class, event -> Call.clientPacketReliable(event.player.con, "SendMeSubtitle", null));

        netServer.addPacketHandler("MySubtitle", (player, text) -> player.kick("Mod Scheme Size is prohibited on this server."));

        Log.infoTag("AntiSchemeSize", "Loaded");
    }
}
