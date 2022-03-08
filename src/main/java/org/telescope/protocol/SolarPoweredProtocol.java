
package org.telescope.protocol;

import org.telescope.server.BaseProtocol;
import org.telescope.server.PipelineBuilder;
import org.telescope.server.TrackerServer;

public class SolarPoweredProtocol extends BaseProtocol {

    public SolarPoweredProtocol() {
        addServer(new TrackerServer(false, getName()) {
            @Override
            protected void addProtocolHandlers(PipelineBuilder pipeline) {
                pipeline.addLast(new HuabaoFrameDecoder());
                pipeline.addLast(new SolarPoweredProtocolDecoder(SolarPoweredProtocol.this));
            }
        });
    }

}