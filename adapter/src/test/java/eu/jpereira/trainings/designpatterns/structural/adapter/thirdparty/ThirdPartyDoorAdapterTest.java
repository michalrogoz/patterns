/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import static org.junit.Assert.*;
import eu.jpereira.trainings.designpatterns.structural.adapter.DoorTest;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.SimpleDoor;

/**
 * @author windows
 * 
 */
public class ThirdPartyDoorAdapterTest extends DoorTest {

	@Override
	protected Door createDoorUnderTest() {
		//return new SimpleDoor();
		return new ThirdPartyDoorAdapter();
	}

	@Override
	protected String getDefaultDoorCode() {
		//return SimpleDoor.DEFAULT_DOOR_CODE;
		return ThirdPartyDoor.DEFAULT_CODE;
	}

}
