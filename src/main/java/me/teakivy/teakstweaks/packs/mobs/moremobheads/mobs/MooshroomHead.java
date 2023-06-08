package me.teakivy.teakstweaks.packs.mobs.moremobheads.mobs;

import me.teakivy.teakstweaks.packs.mobs.moremobheads.BaseMobHead;
import me.teakivy.teakstweaks.packs.mobs.moremobheads.Head;
import me.teakivy.teakstweaks.packs.mobs.moremobheads.MobHeads;
import org.bukkit.Sound;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MushroomCow;
import org.bukkit.event.entity.EntityDeathEvent;

public class MooshroomHead extends BaseMobHead {

    public MooshroomHead() {
        super(EntityType.MUSHROOM_COW, "red-mooshroom", Sound.ENTITY_COW_AMBIENT);

        addHeadTexture("red", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGE4MDYwNmU4MmM2NDJmMTQxNTg3NzMzZTMxODBhZTU3ZjY0NjQ0MmM5ZmZmZDRlNTk5NzQ1N2UzNDMxMWEyOSJ9fX0");
        addHeadTexture("brown", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2U2NDY2MzAyYTVhYjQzOThiNGU0NzczNDk4MDhlNWQ5NDAyZWEzYWQ4ZmM0MmUyNDQ2ZTRiZWQwYTVlZDVlIn19fQ");
    }

    @Override
    public boolean dropHead(EntityDeathEvent event) {
        MushroomCow mooshroom = (MushroomCow) event.getEntity();

        String key = this.key;
        if (mooshroom.getVariant() == MushroomCow.Variant.BROWN) key = "brown-mooshroom";

        return MobHeads.dropChance(event.getEntity().getKiller(), Head.getChance(key));
    }

    @Override
    public String getTexture(EntityDeathEvent event) {
        MushroomCow mooshroom = (MushroomCow) event.getEntity();

        if (mooshroom.getVariant() == MushroomCow.Variant.BROWN) return this.textures.get("brown");

        return this.textures.get("red");
    }

    @Override
    public String getName(EntityDeathEvent event) {
        MushroomCow mooshroom = (MushroomCow) event.getEntity();

        if (mooshroom.getVariant() == MushroomCow.Variant.BROWN) return "Brown Mooshroom";

        return "Red Mooshroom";
    }
}