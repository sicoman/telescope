
package org.telescope.protocol;

import org.telescope.server.BaseProtocol;
import org.telescope.server.PipelineBuilder;
import org.telescope.server.TrackerServer;

import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

public class SpotProtocol extends BaseProtocol {

    public SpotProtocol() {
        addServer(new TrackerServer(false, getName()) {
            @Override
            protected void addProtocolHandlers(PipelineBuilder pipeline) {
                pipeline.addLast(new HttpResponseEncoder());
                pipeline.addLast(new HttpRequestDecoder());
                pipeline.addLast(new HttpObjectAggregator(65535));
                pipeline.addLast(new SpotProtocolDecoder(SpotProtocol.this));
            }
        });
    }

}
