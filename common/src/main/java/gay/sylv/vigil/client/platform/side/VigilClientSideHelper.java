package gay.sylv.vigil.client.platform.side;

import gay.sylv.vigil.Vigil;
import gay.sylv.vigil.platform.side.VigilSideHelper;

public class VigilClientSideHelper implements VigilSideHelper<VigilClientSideHelper> {
	public static VigilClientSideHelper getInstance() {
		return (VigilClientSideHelper) Vigil.getSideHelper();
	}

	@Override
	public Class<? extends VigilSideHelper<VigilClientSideHelper>> type() {
		return VigilClientSideHelper.class;
	}

	@Override
	public VigilSideHelper<VigilClientSideHelper> get() {
		return this;
	}
}
