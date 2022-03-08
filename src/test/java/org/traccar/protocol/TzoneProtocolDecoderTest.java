package org.telescope.protocol;

import org.junit.Test;
import org.telescope.ProtocolTest;

public class TzoneProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = new TzoneProtocolDecoder(null);

        verifyAttributes(decoder, binary(
                "545A004B2424041302000000086706003324776413030C0A1A2900180513030C0A1A25080F7E1028CAC830000A000F0000000005000AA53201633D05046000010009AA201737019408973B0032B0260D0A"));

        verifyAttributes(decoder, binary(
                "545a005b24240406010800000866050033819630120911071824000472bd8e5b0008aac01b07019b04bb002f00040b06161154000e100132ff2006161152000e080096ff4606161151000e1e0101ff1406161156000db6405bff490024469e0d0a"));

        verifyAttributes(decoder, binary(
                "545a006624240406010800000866050033819630120911070e1d000472bd8e5b0008aac01b17019b04bc003a00050b06161151000e1e00ffff1406161152000e08008aff4706161154000e100134ff1f06161156000db0406cff4906161155000df44011ff4e0023811a0d0a"));

        verifyPosition(decoder, binary(
                "545a005624240111010e0000086169303626931411091b151d2600160801de26ec002f633411091b151d2500000000160c0000040d2a34df000eaa4000001b37016000000000319c0000000000000000000000000000003a84240d0a"));

        verifyPosition(decoder, binary(
                "545a005024240153011000000863835025559464110103080a22001609011bed79245964a9110103080a22000a0000550c00000604396f04222c000daac000151701a204870000000000000003000959000546190d0a"));

        verifyPosition(decoder, binary(
                "545A005224240153010E000008638350256668551008130616090016050079F63D2527FAF710081306160900A000002F0D33000803015B07013D7976000DAAE0400537016C049E000000000000000300800002B65EEA0D0A"));

        verifyPosition(decoder, binary(
                "545a00582424010b022000000860041028904798100803030c2700160a007da96203356669100803030c2700000000000e000004002813730010aa4000000617017100000000000080000000000000000000000000000000007701fe0d0a"));

        verifyPosition(decoder, binary(
                "545a00582424010b022000000860041028904798100803030d1a001609007da9620335666a100803030d1900000000000e000004002813730010aa400000063701720000000000008000000000000000000000000000000000787f0c0d0a"));

        verifyPosition(decoder, binary(
                "545a00582424010b021e000008637710239476270f080b0a3228001600000000000000000000000000000000000000000000000401a00822001088c00020183701a6053800000000800000000000000000000000000000000077c9860d0a"),
                position("1999-11-30 00:00:00.000", false, 0.0, 0.0));

        verifyPosition(decoder, binary(
                "545A00912424010B021E000008661040203754350F061807083800160400CE5ADC041447620F0618070838000A0000060C7C0004253378370010AAC000000C37018504E500000000800000000000000000390B0A0014061113000000051200140610600014061220001000133800140610070010001473001000151100101500640010000920001000148400000000000000F2EF570D0A"),
                position("2015-06-24 07:08:56.000", true, 22.53946, 114.06310));

        verifyAttributes(decoder, binary(
                "545A009E2424010A0205000008637710225481290F010F081E33000000000010A0C000310E35000005840000000000000000000000000066140A00140612200010001511001406101000140612490014061308001015006400051400170014061012000000050200140612470000000504001406100700140612510014061260001015012000000005080014061252001406130900101501410000000506000853A40D0A"));

        verifyAttributes(decoder, binary(
                "545A00992424010A0205000008637710225481290F010F082634000000000010A0C000311035000005870000000000000000000000000061130A000000050800101500640014061251001406130800051400170010150141001406101000140612200014061309000000050200140610070014061260001406124900140612470014061012001406125200100015110010150120000000050400183E8A0D0A"));

        verifyAttributes(decoder, binary(
                "545A00942424010A0205000008637710225481290F010F091C1F000000000010A1C000310F3500000586000000000000000000000000005C120A001406101000140612490014061012001406125200000005040000000502001015012000000005080010001511001406122000140612600014061247001406130900140610070010150141000514001700140612510010150064007A907C0D0A"));

    }

}
