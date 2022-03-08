
package org.telescope.protocol;

import org.telescope.server.BaseProtocol;
import org.telescope.server.CharacterDelimiterFrameDecoder;
import org.telescope.server.PipelineBuilder;
import org.telescope.server.TrackerServer;

import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class FoxProtocol extends BaseProtocol {

    public FoxProtocol() {
        addServer(new TrackerServer(false, getName()) {
            @Override
            protected void addProtocolHandlers(PipelineBuilder pipeline) {
                pipeline.addLast(new CharacterDelimiterFrameDecoder(1024, "</fox>"));
                pipeline.addLast(new StringDecoder());
                pipeline.addLast(new StringEncoder());
                pipeline.addLast(new FoxProtocolDecoder(FoxProtocol.this));
            }
        });
    }

}