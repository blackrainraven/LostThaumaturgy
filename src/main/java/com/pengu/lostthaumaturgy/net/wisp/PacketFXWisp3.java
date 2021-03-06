package com.pengu.lostthaumaturgy.net.wisp;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mrdimka.hammercore.net.packetAPI.IPacket;
import com.mrdimka.hammercore.net.packetAPI.IPacketListener;
import com.mrdimka.hammercore.proxy.ParticleProxy_Client;
import com.pengu.lostthaumaturgy.client.fx.FXWisp;

public class PacketFXWisp3 implements IPacket, IPacketListener<PacketFXWisp3, IPacket>
{
	double x, y, z, tx, ty, tz;
	float partialTicks;
	int type, color;
	
	public PacketFXWisp3(double x, double y, double z, double tx, double ty, double tz, float partialTicks, int type, int color)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
		this.partialTicks = partialTicks;
		this.type = type;
		this.color = color;
	}
	
	public PacketFXWisp3(double x, double y, double z, float partialTicks, int type, int color)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.tx = x;
		this.ty = y;
		this.tz = z;
		this.partialTicks = partialTicks;
		this.type = type;
		this.color = color;
	}
	
	public PacketFXWisp3()
	{
	}
	
	@Override
	public IPacket onArrived(PacketFXWisp3 packet, MessageContext context)
	{
		if(context.side == Side.CLIENT)
			summon();
		return null;
	}
	
	@SideOnly(Side.CLIENT)
	private void summon()
	{
		FXWisp wisp;
		ParticleProxy_Client.queueParticleSpawn(wisp = new FXWisp(Minecraft.getMinecraft().world, x, y, z, tx, ty, tz, partialTicks, type));
		wisp.setColor(color);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		nbt.setDouble("x", x);
		nbt.setDouble("y", y);
		nbt.setDouble("z", z);
		nbt.setDouble("tx", tx);
		nbt.setDouble("ty", ty);
		nbt.setDouble("tz", tz);
		nbt.setFloat("p", partialTicks);
		nbt.setInteger("type", type);
		nbt.setInteger("color", color);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		x = nbt.getDouble("x");
		y = nbt.getDouble("y");
		z = nbt.getDouble("z");
		tx = nbt.getDouble("tx");
		ty = nbt.getDouble("ty");
		tz = nbt.getDouble("tz");
		partialTicks = nbt.getFloat("p");
		type = nbt.getInteger("type");
		color = nbt.getInteger("color");
	}
}