package trcmoe.backgroundblock.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import trcmoe.backgroundblock.BackgroundBlock;

public class ModItems {
//    public static final Item BATON = registerItem("baton",
//            new Item(new FabricItemSettings()),
//            ModItemGroups.BATON);
    @SafeVarargs
    public static Item registerItem(String name, Item item, RegistryKey<ItemGroup>... itemGroups) {
        Item registerItem = Registry.register(Registries.ITEM, new Identifier(BackgroundBlock.MOD_ID, name), item);
        for (RegistryKey<ItemGroup> itemGroup : itemGroups) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> {
                entries.add(registerItem);
            });
        }
        return registerItem;
    }
    public static void registerModItems() {
        BackgroundBlock.LOGGER.debug("Registering mod items for" + BackgroundBlock.MOD_ID);
    }
}
