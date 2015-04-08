/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Maxime Dor
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

package org.altherian.hboxd.event.system;

import org.altherian.hbox.event.Event;
import org.altherian.hbox.event.HyperboxEvents;
import org.altherian.hbox.states.ServerState;

public final class SystemStateEvent extends Event {

   public SystemStateEvent(ServerState state) {
      super(HyperboxEvents.SystemState);
      set(ServerState.class, state);
   }

   public ServerState getState() {
      return get(ServerState.class);
   }

   @Override
   public String toString() {
      return "System state changed to " + getState() + " @ " + getTime();
   }

}
