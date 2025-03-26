package gay.sylv.vigil.server.dedicated.platform.side;

import gay.sylv.vigil.Vigil;
import gay.sylv.vigil.platform.side.VigilSideHelper;

public class VigilDedicatedSideHelper implements VigilSideHelper<VigilDedicatedSideHelper> {
	static VigilDedicatedSideHelper getInstance() {
		return (VigilDedicatedSideHelper) Vigil.getSideHelper();
	}

	@Override
	public Class<? extends VigilSideHelper<VigilDedicatedSideHelper>> type() {
		return VigilDedicatedSideHelper.class;
	}

	@Override
	public VigilSideHelper<VigilDedicatedSideHelper> get() {
		return this;
	}
}
