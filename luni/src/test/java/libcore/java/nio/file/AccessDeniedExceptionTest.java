/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package libcore.java.nio.file;

import junit.framework.TestCase;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileSystemException;
import libcore.util.SerializationTester;

public class AccessDeniedExceptionTest extends TestCase {

    public void test_constructor$String() {
        AccessDeniedException exception = new AccessDeniedException("file");
        assertEquals("file", exception.getFile());
        assertNull(exception.getOtherFile());
        assertNull(exception.getReason());

        assertTrue(exception instanceof FileSystemException);
    }

    public void test_constructor$String$String$String() {
        AccessDeniedException exception = new AccessDeniedException("file", "otherFile", "reason");
        assertEquals("file", exception.getFile());
        assertEquals("otherFile", exception.getOtherFile());
        assertEquals("reason", exception.getReason());
    }

    public void test_serialization() throws IOException, ClassNotFoundException {
        String hex = "ACED0005737200236A6176612E6E696F2E66696C652E41636365737344656E6965644578"
                + "63657074696F6E44993D6BF81C2721020000787200216A6176612E6E696F2E66696C652E46696C65"
                + "53797374656D457863657074696F6ED598F27876D360FC0200024C000466696C657400124C6A6176"
                + "612F6C616E672F537472696E673B4C00056F7468657271007E0002787200136A6176612E696F2E49"
                + "4F457863657074696F6E6C8073646525F0AB020000787200136A6176612E6C616E672E4578636570"
                + "74696F6ED0FD1F3E1A3B1CC4020000787200136A6176612E6C616E672E5468726F7761626C65D5C6"
                + "35273977B8CB0300044C000563617573657400154C6A6176612F6C616E672F5468726F7761626C65"
                + "3B4C000D64657461696C4D65737361676571007E00025B000A737461636B547261636574001E5B4C"
                + "6A6176612F6C616E672F537461636B5472616365456C656D656E743B4C0014737570707265737365"
                + "64457863657074696F6E737400104C6A6176612F7574696C2F4C6973743B787071007E0009740006"
                + "726561736F6E7572001E5B4C6A6176612E6C616E672E537461636B5472616365456C656D656E743B"
                + "02462A3C3CFD22390200007870000000097372001B6A6176612E6C616E672E537461636B54726163"
                + "65456C656D656E746109C59A2636DD8502000449000A6C696E654E756D6265724C000E6465636C61"
                + "72696E67436C61737371007E00024C000866696C654E616D6571007E00024C000A6D6574686F644E"
                + "616D6571007E000278700000002674002F6C6962636F72652E6A6176612E6E696F2E66696C652E41"
                + "636365737344656E696564457863657074696F6E5465737474001E41636365737344656E69656445"
                + "7863657074696F6E546573742E6A617661740025746573745F636F6E7374727563746F7224537472"
                + "696E6724537472696E6724537472696E677371007E000DFFFFFFFE7400186A6176612E6C616E672E"
                + "7265666C6563742E4D6574686F6474000B4D6574686F642E6A617661740006696E766F6B65737100"
                + "7E000D000000F9740028766F6761722E7461726765742E6A756E69742E4A756E69743324566F6761"
                + "724A556E69745465737474000B4A756E6974332E6A61766174000372756E7371007E000D00000063"
                + "740020766F6761722E7461726765742E6A756E69742E4A556E697452756E6E657224317400104A55"
                + "6E697452756E6E65722E6A61766174000463616C6C7371007E000D0000005C740020766F6761722E"
                + "7461726765742E6A756E69742E4A556E697452756E6E657224317400104A556E697452756E6E6572"
                + "2E6A61766174000463616C6C7371007E000D000000ED74001F6A6176612E7574696C2E636F6E6375"
                + "7272656E742E4675747572655461736B74000F4675747572655461736B2E6A61766174000372756E"
                + "7371007E000D0000046D7400276A6176612E7574696C2E636F6E63757272656E742E546872656164"
                + "506F6F6C4578656375746F72740017546872656164506F6F6C4578656375746F722E6A6176617400"
                + "0972756E576F726B65727371007E000D0000025F74002E6A6176612E7574696C2E636F6E63757272"
                + "656E742E546872656164506F6F6C4578656375746F7224576F726B6572740017546872656164506F"
                + "6F6C4578656375746F722E6A61766174000372756E7371007E000D000002F97400106A6176612E6C"
                + "616E672E54687265616474000B5468726561642E6A61766174000372756E7372001F6A6176612E75"
                + "74696C2E436F6C6C656374696F6E7324456D7074794C6973747AB817B43CA79EDE02000078707874"
                + "000466696C657400096F7468657246696C65";
        AccessDeniedException exception = (AccessDeniedException)
                SerializationTester.deserializeHex(hex);

        String hex1 = SerializationTester.serializeHex(exception).toString();
        assertEquals(hex, hex1);
        assertEquals("file", exception.getFile());
        assertEquals("otherFile", exception.getOtherFile());
        assertEquals("reason", exception.getReason());
    }
}
