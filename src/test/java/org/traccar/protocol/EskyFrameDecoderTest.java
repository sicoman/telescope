package org.traccar.protocol;

import org.junit.Test;
import org.traccar.ProtocolTest;

public class EskyFrameDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = new EskyFrameDecoder();

        verifyNull(
                decoder.decode(null, null, binary("00")));

        verifyFrame(
                binary("454f3b303b3836313331313030363436313930383b523b363b3138303432303130343735313b322e39373839363b3130312e36353039313b302e37353b3332303b333339383b313b7c"),
                decoder.decode(null, null, binary("454f3b303b3836313331313030363436313930383b523b363b3138303432303130343735313b322e39373839363b3130312e36353039313b302e37353b3332303b333339383b313b7c")));

        verifyFrame(
                binary("454c3b313b3836343930363032393139363632363b3137303832323134333432363b"),
                decoder.decode(null, null, binary("454c3b313b3836343930363032393139363632363b3137303832323134333432363b")));

        verifyFrame(
                binary("454f3b303b3836343930363032393139363632363b523b302b3137303830383135353335322b302e30303030302b302e30303030302b302e30302b302b3078312b302b302b302b31323333"),
                decoder.decode(null, null, binary("454f3b303b3836343930363032393139363632363b523b302b3137303830383135353335322b302e30303030302b302e30303030302b302e30302b302b3078312b302b302b302b31323333")));

        verifyFrame(
                binary("454f3b303b3836343930363032393139363632363b523b302b3137303830383135353335322b302e30303030302b302e30303030302b302e30302b302b3078312b302b302b302b31323333"),
                decoder.decode(null, null, binary("454f3b303b3836343930363032393139363632363b523b302b3137303830383135353335322b302e30303030302b302e30303030302b302e30302b302b3078312b302b302b302b31323333454f3b303b3836343930363032393139363632363b523b302b3137303830383135353335322b302e30303030302b302e30303030302b302e30302b302b3078312b302b302b302b31323333")));

    }

}
