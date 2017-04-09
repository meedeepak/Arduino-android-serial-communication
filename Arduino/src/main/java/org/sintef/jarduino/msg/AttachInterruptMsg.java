/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Authors: Franck Fleurey and Brice Morin
 * Company: SINTEF IKT, Oslo, Norway
 * Date: 2011
 */
package org.sintef.jarduino.msg;

import org.sintef.jarduino.*;

public class AttachInterruptMsg extends JArduinoProtocolPacket {

	private InterruptPin interrupt;
	private InterruptTrigger mode;
	
	public AttachInterruptMsg(InterruptPin interrupt, InterruptTrigger mode) {
		setCommandID(JArduinoProtocol.ATTACH_INTERRUPT);
		setByteValue(interrupt.getValue());
		this.interrupt = interrupt;
		setByteValue(mode.getValue());
		this.mode = mode;
	}
	
	public AttachInterruptMsg(byte[] packet) {
		setPacketData(packet);
		interrupt = InterruptPin.fromValue(buffer.get());		
		mode = InterruptTrigger.fromValue(buffer.get());		
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleAttachInterrupt(this);
	}

	@Override
	public String toString(){
		String myString = "attachInterrupt:";
		myString += " [interrupt: "+interrupt+"]";
		myString += " [mode: "+mode+"]";
		return myString;
	}

	public InterruptPin getInterrupt() {
		return interrupt;
	}
	
	public InterruptTrigger getMode() {
		return mode;
	}
	
}