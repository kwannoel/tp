package seedu.address.model.attendance;

import seedu.address.model.person.Name;
import seedu.address.model.person.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.SortedSet;

/**
 * Updates to a person's attendance should take place through this interface primarily.
 */
public class AttendanceTable {
    private ArrayList<AttendanceRow> attendanceTable;

    private AttendanceTable(ArrayList<AttendanceRow> attendanceTable) {
        this.attendanceTable = attendanceTable;
    };

    public static AttendanceTable emptyAttendanceTable() {
        return new AttendanceTable(new ArrayList<>());
    }

    /**
     * @param date - Adds a new date column
     */
    public void addDateColumn(Date date) {
    }

    /**
     * @param person - Adds a new person to the attendance table
     */
    public void addAttendanceForPerson(Person person) {
    }

    /**
     * TODO implement this
     * @param start - Start of sem
     * @param end - End of sem
     * @param daysOfWeek - Recurring lessons
     */
    public static AttendanceTable newSemesterAttendance(Date start, Date end, DaysOfWeek daysOfWeek) {
        return emptyAttendanceTable();
    }

    private void addAttendanceRow(AttendanceRow attendanceRow) {
    }

    /**
     * Contains a reference to the person.
     * Since attendance is an attribute of Person, we can access it through our reference as well
     */
    class AttendanceRow {
        private Person person;

        public AttendanceRow(Person person) {
            this.person = person;
        }

        public Name getPersonName() {
            return person.getName();
        }
        public SortedSet<Attendance> getAttendanceList() {
            return person.getAttendances();
        }
    }

    enum DaysOfWeek {
        MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT,
        SUN,
    }
}
