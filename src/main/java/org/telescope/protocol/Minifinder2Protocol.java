
package org.telescope.protocol;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.nio.ByteOrder;

import org.telescope.server.BaseProtocol;
import org.telescope.server.PipelineBuilder;
import org.telescope.server.TrackerServer;

public class Minifinder2Protocol extends BaseProtocol {

    public Minifinder2Protocol() {
        addServer(new TrackerServer(false, getName()) {
            @Override
            protected void addProtocolHandlers(PipelineBuilder pipeline) {
                pipeline.addLast(new LengthFieldBasedFrameDecoder(ByteOrder.LITTLE_ENDIAN, 1200, 2, 2, 4, 0, true));
                pipeline.addLast(new Minifinder2ProtocolDecoder(Minifinder2Protocol.this));
            }
        });
    }

}