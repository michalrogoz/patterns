package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

import static eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.ThirdPartyDoor.*;

public class ThirdPartyDoorObjectAdapter implements Door {

    private ThirdPartyDoor thirdPartyDoor = new ThirdPartyDoor();

    @Override
    public void open(String code) throws IncorrectDoorCodeException {
        try {
            thirdPartyDoor.unlock(code);
            thirdPartyDoor.setState(DoorState.OPEN);
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException();
        } catch (CannotChangeStateOfLockedDoor cannotChangeStateOfLockedDoor) {
            cannotChangeStateOfLockedDoor.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            thirdPartyDoor.setState(DoorState.CLOSED);
        } catch (CannotChangeStateOfLockedDoor cannotChangeStateOfLockedDoor) {
            cannotChangeStateOfLockedDoor.printStackTrace();
        }
    }

    @Override
    public boolean isOpen() {
        DoorState state = thirdPartyDoor.getState();
        return state == DoorState.OPEN;
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {
        if (!newCode.equals(newCodeConfirmation)) throw new CodeMismatchException();

        try {
            thirdPartyDoor.unlock(oldCode);
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException();
        }

        try {
            thirdPartyDoor.setNewLockCode(newCode);
        } catch (CannotChangeCodeForUnlockedDoor cannotChangeCodeForUnlockedDoor) {
            cannotChangeCodeForUnlockedDoor.printStackTrace();
        }
    }

    @Override
    public boolean testCode(String code) {
        try {
            thirdPartyDoor.unlock(code);
            thirdPartyDoor.lock();
            return true;
        } catch (CannotUnlockDoorException e) {
            return false;
        }

    }
}
