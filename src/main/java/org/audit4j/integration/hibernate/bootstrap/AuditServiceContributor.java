/*
 * This source is a part of Audit4j - An open source auditing framework.
 * http://audit4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.audit4j.integration.hibernate.bootstrap;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.spi.ServiceContributor;

/**
 * The Class AuditServiceContributor.
 * 
 * @author <a href="mailto:janith3000@gmail.com">Janith Bandara</a>
 */
public class AuditServiceContributor implements ServiceContributor{

    /* (non-Javadoc)
     * @see org.hibernate.service.spi.ServiceContributor#contribute(org.hibernate.boot.registry.StandardServiceRegistryBuilder)
     */
    @Override
    public void contribute(StandardServiceRegistryBuilder serviceRegistryBuilder) {
        System.out.println("contributing...");

        serviceRegistryBuilder.addInitiator( AuditServiceInitiator.INSTANCE );
    }
}