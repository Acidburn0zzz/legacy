/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2014 Maxime Dor
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

package org.altherian.hboxd.event.service;

import org.altherian.hbox.event.HyperboxEvents;
import org.altherian.hbox.states.ServiceState;
import org.altherian.hboxd.service._Service;

public class ServiceStateEvent extends ServiceEvent {

   public ServiceStateEvent(_Service service, ServiceState state) {
      super(HyperboxEvents.ServiceState, service);
      set(ServiceState.class, state);
   }

   public ServiceState getState() {
      return get(ServiceState.class);
   }

}
