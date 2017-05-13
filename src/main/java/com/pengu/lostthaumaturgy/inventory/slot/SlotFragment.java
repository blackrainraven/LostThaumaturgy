package com.pengu.lostthaumaturgy.inventory.slot;

import com.pengu.lostthaumaturgy.init.ItemsLT;
import com.pengu.lostthaumaturgy.items.ItemResearch;
import com.pengu.lostthaumaturgy.items.ItemResearch.EnumResearchItemType;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotFragment extends Slot
{
	public SlotFragment(IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return !stack.isEmpty() && stack.getItem() == ItemsLT.DISCOVERY && ItemResearch.getType(stack) == EnumResearchItemType.FRAGMENT;
	}
}