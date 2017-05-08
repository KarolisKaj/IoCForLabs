
namespace IoCAutoFac
{
    using Autofac;
    using IoCAutoFacAttributes.Dependencies;
    using IoCAutoFacAttributes.Interfaces;
    using System;
    public class AutoFacAttributes : IDisposable
    {
        private IContainer Container { get; set; }
        public void Compose()
        {
            var builder = new ContainerBuilder();
            // Singleton
            builder.RegisterType<PrimaryService>()
                .As<IService>()
                .SingleInstance()
                .AutoActivate();
            // Request instance type
            builder.RegisterType<SecondaryService>().As<IService>().InstancePerDependency();
            builder.RegisterType<EuropeanCalendar>().As<ICalendar>().InstancePerDependency();
            builder.RegisterType<GenericCalendar>().As<ICalendar>().InstancePerDependency().AutoActivate();

            // Autowire selected property
            builder.RegisterType<CalendarFactory>()
                .As<ICalendarFactory>()
                .SingleInstance()
                .PropertiesAutowired((propInfo, o) => propInfo.GetType() == typeof(IService)).AutoActivate() ;

            var Container = builder.Build();

            Container.Print();

            Console.ReadLine();
        }

        public void Dispose()
        {
            Container.ComponentRegistry.Dispose();
        }
    }
}