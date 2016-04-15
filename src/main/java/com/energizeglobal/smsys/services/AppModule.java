package com.energizeglobal.smsys.services;

import org.apache.tapestry5.ioc.ServiceBinder;

//
//import org.apache.tapestry5.SymbolConstants;
//import org.apache.tapestry5.ioc.MappedConfiguration;
//import org.apache.tapestry5.ioc.ServiceBinder;
//
///**
// * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to
// * configure and extend Tapestry, or to place your own service definitions.
// */
public class AppModule
{

    public static void bind(ServiceBinder binder)
    {

    }
//    public static void bind(ServiceBinder binder)
//    {
//        // Bind any services needed by the QA team to produce their reports
//        // binder.bind(MyServiceMonitorInterface.class, MyServiceMonitorImpl.class);
//    }
//
//
//    public static void contributeApplicationDefaults(
//            MappedConfiguration<String, Object> configuration)
//    {
//        // The factory default is true but during the early stages of an application
//        // overriding to false is a good idea. In addition, this is often overridden
//        // on the command line as -Dtapestry.production-mode=false
//        configuration.add(SymbolConstants.PRODUCTION_MODE, false);
//
//        // The application version number is incorprated into URLs for some
//        // assets. Web browsers will cache assets because of the far future expires
//        // header. If existing assets are changed, the version number should also
//        // change, to force the browser to download new versions.
//        configuration.add(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT-QA");
//    }
}
