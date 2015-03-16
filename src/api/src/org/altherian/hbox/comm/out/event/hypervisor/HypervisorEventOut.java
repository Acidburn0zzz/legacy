/*
 * Hyperbox - Enterprise Virtualization Manager
 * Copyright (C) 2013 Maxime Dor
 * hyperbox at altherian dot org
 * 
 * http://hyperbox.altherian.org
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

package org.altherian.hbox.comm.out.event.hypervisor;

import org.altherian.hbox.comm.out.ServerOut;
import org.altherian.hbox.comm.out.event.EventOut;
import org.altherian.hbox.comm.out.hypervisor.HypervisorOut;
import java.util.Date;

public class HypervisorEventOut extends EventOut {

   protected HypervisorEventOut() {
      // Used for serialization
   }

   public HypervisorEventOut(Date time, Enum<?> id, ServerOut srvOut, HypervisorOut hypOut) {
      super(time, id, srvOut);
      if (hypOut != null) {
         set(HypervisorOut.class, hypOut);
      }
   }

   public HypervisorOut getHypervisor() {
      return get(HypervisorOut.class);
   }

   @Override
   public String toString() {
      return "Event ID " + getId() + " occured @ " + getTime() + " for Hypervisor " + getHypervisor().getId() + " on Server " + getServer().getName();
   }

}
