package com.lukeplechaty.oat.proxy;
import com.lukeplechaty.oat.setBlocks;
import com.lukeplechaty.oat.setEntites;
import com.lukeplechaty.oat.setItems;

public class ClientProxy implements CommonProxy
{
	@Override
	public void init()
	{
		setItems.registerRenders();
		setBlocks.registerRenders();
		setEntites.registerRenders();
	}
}
