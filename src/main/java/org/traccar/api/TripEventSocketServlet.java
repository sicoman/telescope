/*
 * Copyright 2015 - 2021 Anton Tananaev (anton@traccar.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.traccar.api;

import org.eclipse.jetty.websocket.server.JettyWebSocketServlet;
import org.eclipse.jetty.websocket.server.JettyWebSocketServletFactory;
import org.traccar.Context;
import org.traccar.config.Keys;
import java.time.Duration;

public class TripEventSocketServlet extends JettyWebSocketServlet {

    @Override
    public void configure(JettyWebSocketServletFactory factory) {
        factory.setIdleTimeout(Duration.ofMillis(Context.getConfig().getLong(Keys.WEB_TIMEOUT)));
        factory.setCreator((req, resp) -> {
        
            if (!req.getParameterMap().containsKey("token")) {
                return null;
            }
        
            String apiKey = req.getParameterMap().get("token").get(0);
            
            if (!apiKey.equals("cXJ1ejoxMjM0NTY3ODk=")) {
                return null;
            }

            if (req.getParameterMap().containsKey("logId")) {
                String logId = req.getParameterMap().get("logId").get(0);
                if (logId != null) {
                    if (req.getParameterMap().containsKey("dataSource")) {
                        String dataSource = req.getParameterMap().get("dataSource").get(0);
                        if (dataSource != null && Boolean.parseBoolean(dataSource)) {
                            return new TripEventSocket(logId, true);
                        }
                    }
                    return new TripEventSocket(logId, false);
                }
            }
            
            return null;
        });
    }

}
