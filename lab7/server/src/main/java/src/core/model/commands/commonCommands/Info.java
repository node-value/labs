package src.core.model.commands.commonCommands;

import src.core.model.commands.Command;
import src.core.model.elements.*;
import src.core.model.handlers.CollectionHandler;
import src.util.User;

/** Class, makes object from command */
public class Info implements Command<String> {

    private CollectionHandler collectionHandler;

    private User user;

    public Info(CollectionHandler collectionHandler, User user) {
        this.collectionHandler = collectionHandler;
        this.user = user;
    }

    @Override
    public String execute() {
        return collectionHandler.info(user);
    }
}
