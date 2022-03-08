package org.telescope.protocol;

import org.junit.Test;
import org.telescope.ProtocolTest;

public class WristbandProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = new WristbandProtocolDecoder(null);

        verifyNotNull(decoder, binary(
                "000102004459583836383730343034343735303035357c56312e307c317c7b4630342331382c30372c332c3539303139322c33303a31382c30372c332c3539303139322c33307d0d0afffefc"));

        verifyNotNull(decoder, binary(
                "000102009c59583836383730343034343735303035357c56312e307c317c7b4630332330383a30353a38313a64383a31383a38372c2d37365f30303a37663a32383a63373a62613a63312c2d37375f39633a33643a63663a65643a62643a36622c2d36335f64383a65623a39373a65653a37373a32342c2d38327c31382c30372c332c3539303735342c33303a31382c30372c332c3539303735342c33307d0d0afffefc"));

        verifyNull(decoder, binary(
                "000102002259583836383730343034343735303035357c56312e307c307c7b46363423317d0d0afffefc"));

        verifyPositions(decoder, binary(
                "00010200bc59583836383730343034343735303035357c56312e307c317c7b4630322337372e3437373831372c2d33382e3839363239322c3230313831323239313235352c302e35387c37372e3437373739362c2d33382e3839363234352c3230313831323239313235352c302e30307c37372e3437373738392c2d33382e3839363233322c3230313831323239313235352c302e30307c37372e3437373737362c2d33382e3839363232322c3230313831323239313235352c302e30307d0d0afffefc"));

        verifyNull(decoder, binary(
                "000102004759583836383730343034343735303035357c56312e307c317c7b463931233331305f30307c30307c30307c30307c57414e444149323031382f31322f31342031353a35367d0d0afffefc"));

        verifyNull(decoder, binary(
                "000102004159583336373535313631303030303934347c56312e307c317c7b4639312330317c30307c30307c33475f7065745f323031382f30352f31362031313a30307d0d0afffefc"));

        verifyPositions(decoder, false, binary(
                "000102003559583836383730343034343735303035357c56312e307c317c7b4630312339342c312c3130302c302c33313030302c3930307d0d0afffefc"));

    }

}
