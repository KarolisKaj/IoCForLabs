namespace IoCAutoFac
{
    using Autofac;
    using IoCAutoFacAttributes.Dependencies;
    using IoCAutoFacAttributes.Interfaces;
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class AutoFacAttributes : IDisposable
    {
        private IContainer Container { get; set; }
        public void Compose()
        {
            var builder = new ContainerBuilder();
            // Singleton, method injection
            builder.RegisterType<PrimaryService>()
                .As<IService>()
                .SingleInstance()
                .AutoActivate()
                .OnActivating(instance => instance.Instance.PrintCalendarInfo(new GenericCalendar()))
                .WithMetadata<PriorityMeta>((a) => a.For((arg) => arg.Priority, 6000));

            // Request instance type, on creation and on dispose methods
            builder.RegisterType<SecondaryService>().As<IService>()
                .InstancePerDependency()
                .AutoActivate()
                .OnRelease(e => (e as IDisposable)?.Dispose())
                .OnActivated(e => (e.Instance as ICreationInterceptor)?.Execute())
                 .WithMetadata<PriorityMeta>((a) => a.For((arg) => arg.Priority, 5000));

            builder.RegisterType<EuropeanCalendar>().As<ICalendar>().InstancePerDependency().AutoActivate();
            builder.RegisterType<GenericCalendar>().As<ICalendar>().InstancePerDependency().AutoActivate();

            // Autowire selected property
            builder.Register<CalendarFactory>((ctx, args) =>
                 {
                     return new CalendarFactory(ctx.ComponentRegistry.Registrations.Where(x => x.Services.Any(y => y.GetType() == typeof(IService)))
                         .Where(x => { return x.Metadata != null; })
                         .OrderBy(x => x.Metadata) as IService);
                 })
                .AsImplementedInterfaces()
                .SingleInstance()
                .PropertiesAutowired((propInfo, o) => propInfo.GetType() == typeof(IService))
                .AutoActivate();

            Container = builder.Build();

            Container.Print();

            Console.WriteLine("Disposing container");

            Container?.Dispose();

            Console.ReadLine();
        }

        public void Dispose()
        {
            Container.ComponentRegistry.Dispose();
        }
    }
}