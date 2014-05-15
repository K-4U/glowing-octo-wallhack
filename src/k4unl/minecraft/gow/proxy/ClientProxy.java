package k4unl.minecraft.gow.proxy;

import k4unl.minecraft.gow.client.rendering.Renderers;

public class ClientProxy extends CommonProxy {

	
	@Override
	public void initRenderers(){
		Renderers.init();
	}
}
