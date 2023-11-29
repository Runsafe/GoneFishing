package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class MaxSkyBase implements IFishingLootItem
        {
@Override
public RunsafeMeta getItem()
        {
        if (item == null)
        {
        item = Block.Minecraft.Cobblestone.getItem();
        item.setAmount(1);
        item.setDisplayName("§cPiece of Max8abugs Skybase");
        item.addLore("§3This must have washed up from a grief.");
        }
        return item;
        }

private RunsafeMeta item;