/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public enum CommercialClass {

    COMM_TRUCK_OR_TRACTOR           (11),
    TAXI                            (13),
    LIMOUSINE                       (14),
    AGGREGATE_HAULERS               (16),
    SCHOOL_BUS_A                    (17),
    SCHOOL_BUS_B                    (18),
    FOUR_YEAR_COMM_TRAILER          (19),
    COMM_TRAILER                    (21),
    COMM_MOTORCYCLE                 (24),
    FARM_TRUCK                      (31),
    LIGHT_MED_TOW_TRUCK             (32),
    HEAVY_DUTY_TOW_TRUCK            (33),
    SOLID_WASTE                     (39),
    CONSTRUCTOR                     (41),
    FARM_USE                        (51),
    AGRICULTURAL_TRACTOR            (52),
    OMNIBUS_PASSENGER_VEHICLE       (54),
    CONTRACTOR_EQUIP_IN_TRANSIT     (56),
    MIGRANT_FARM_WORKER             (58),
    IN_TRANSIT_EMPTY                (59),
    FARM_LABOR_TRANSPORT            (99);

    public final int code;

    public CommercialClass(int code) {
        this.code = code;
    }

    public int getCode { return code; }

    public CommercialClass getClassFromCode(int code) {
        for (CommercialClass c : values()) {
            if (c.code == code) {
                return c;
            }
        }
        throw new IllegalArgumentException("No class associated with code: "+code);
    }


}