package com.pengu.lostthaumaturgy.client.cfg;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import com.mrdimka.hammercore.cfg.gui.HCConfigGui;
import com.pengu.lostthaumaturgy.LTConfigs;
import com.pengu.lostthaumaturgy.LTInfo;
import com.pengu.lostthaumaturgy.client.gui.GuiInteractive;

public class GuiConfigsLT extends HCConfigGui
{
	public GuiConfigsLT(GuiScreen prev)
	{
		super(prev, LTConfigs.cfgs, LTInfo.MOD_ID);
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		addButton(new GuiButton(14245, 0, 0, 60, 20, "Feedback"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button)
	{
		super.actionPerformed(button);
		if(button.id == 14245)
			mc.displayGuiScreen(new GuiInteractive(this));
	}
}