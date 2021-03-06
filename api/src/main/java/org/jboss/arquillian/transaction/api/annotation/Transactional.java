/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.transaction.api.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Indicates that test will be wrapped in the transaction.
 * <br />
 * It might be defined either on a class or a method level, where
 * latter takes precedence if used.
 * <br />
 * Following modes are available:
 * <ul>
 * <li>{@link TransactionMode#COMMIT} which is the default mode</li>
 * <li>{@link TransactionMode#ROLLBACK}</li>
 * <li>{@link TransactionMode#DISABLED}</li>
 * </ul>
 *
 * @author <a href="mailto:bartosz.majsak@gmail.com">Bartosz Majsak</a>
 */
@Target(value = {TYPE, METHOD})
@Retention(value = RUNTIME)
@Inherited
public @interface Transactional
{

   TransactionMode value() default TransactionMode.DEFAULT;

   /**
    * The optional name of the manager to be used for handling transaction for
    * given test case or method.
    */
   String manager() default "";

}
