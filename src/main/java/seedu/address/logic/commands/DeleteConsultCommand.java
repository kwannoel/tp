package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.consultation.Consultation;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Deletes a consultation
 */
public class DeleteConsultCommand extends Command {
    public static final String COMMAND_WORD = "del-consult";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes a consultation from TAsker.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_SUCCESS = "Consultation deleted: %1$s";

    private final Index targetIndex;

    /**
     * Creates an DeleteConsultCommand to delete the specified {@code Consultation} by supplying its {@code Index}.
     *
     * @param targetIndex Index of consultation being deleted.
     */
    public DeleteConsultCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Consultation> lastShownList = model.getFilteredConsultList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Consultation consultationToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteConsultation(consultationToDelete);
        return new CommandResult(String.format(MESSAGE_SUCCESS, consultationToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteConsultCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteConsultCommand) other).targetIndex));
    }
}