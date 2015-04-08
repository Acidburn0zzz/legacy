/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Maxime Dor
 * hyperbox at altherian dot org
 * 
 * http://kamax.io/hbox/
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.altherian.hboxc.event.connector;

import org.altherian.hboxc.comm.output.ConnectorOutput;
import org.altherian.hboxc.event.ClientEvents;
import org.altherian.hboxc.state.ConnectionState;

public class ConnectorStateChangedEvent extends ConnectorEvent {

   public ConnectorStateChangedEvent(ConnectorOutput conOut, ConnectionState state) {
      super(ClientEvents.ConnectorStateChanged, conOut);
      set(state);
   }

   public ConnectorStateChangedEvent(Enum<?> id, ConnectorOutput conOut, ConnectionState state) {
      super(id, conOut);
      set(state);
   }

   public ConnectionState getState() {
      return get(ConnectionState.class);
   }

   @Override
   public String toString() {
      return "Connector " + getConnector().getLabel() + " state changed to " + getState() + " @ " + getTime();
   }

}
