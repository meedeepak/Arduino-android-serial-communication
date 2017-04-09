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

public class DetachInterruptMsg extends JArduinoProtocolPacket {

	private InterruptPin interrupt;
	
	public DetachInterruptMsg(InterruptPin interrupt) {
		setCommandID(JArduinoProtocol.DETACH_INTERRUPT);
		setByteValue(interrupt.getValue());
		this.interrupt = interrupt;
	}
	
	public DetachInterruptMsg(byte[] packet) {
		setPacketData(packet);
		interrupt = InterruptPin.fromValue(buffer.get());		
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleDetachInterrupt(this);
	}

	@Override
	public String toString(){
		String myString = "detachInterrupt:";
		myString += " [interrupt: "+interrupt+"]";
		return myString;
	}

	public InterruptPin getInterrupt() {
		return interrupt;
	}
	
}