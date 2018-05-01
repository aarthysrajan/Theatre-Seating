/**
 * 
 */
package com.barclays.theatre.seating.model;

/**
 * Enumeration of the state of a reservation. While an order is being processed,
 * the default state will be REQUESTED.
 * 
 * @author Aarthy Rajan
 *
 */
public enum ReservationState {
	REQUESTED, RESERVED, NO_CAPACITY, SPLIT;
}
