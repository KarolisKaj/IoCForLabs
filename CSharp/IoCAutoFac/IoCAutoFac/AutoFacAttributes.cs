namespace IoCAutoFac
{
    using Autofac;
    using Autofac.Core;
    using Autofac.Features.Metadata;
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

            // Primary factory creation
            builder.RegisterType<ServiceFactory>().AsSelf().AutoActivate();

            builder.RegisterType<EuropeanCalendar>().As<ICalendar>().AutoActivate();
            builder.RegisterType<GenericCalendar>().As<ICalendar>().InstancePerDependency().AutoActivate();

            // Autowire selected property
            builder.RegisterType<CalendarFactory>()
                .WithParameter(
                new ResolvedParameter(
                (pi, ctx) => pi.ParameterType == typeof(IService),
                (pi, ctx) => ctx.Resolve<IEnumerable<Meta<int>>>().Max(x => x.Metadata["Priority"])))
                .AsImplementedInterfaces()
                .SingleInstance()
                .PropertiesAutowired((propInfo, o) => propInfo.GetType() == typeof(IService))
                .AutoActivate();

            // Sorry DRY Autowire from different dependency. Than above
            builder.RegisterType<CalendarFactory>()
                .WithParameter(
                new ResolvedParameter(
                (pi, ctx) => pi.ParameterType == typeof(IService),
                (pi, ctx) => ctx.Resolve<IEnumerable<Meta<int>>>().Min(x => x.Metadata["Priority"])))
                .AsImplementedInterfaces()
                .SingleInstance()
                .PropertiesAutowired((propInfo, o) => propInfo.GetType() == typeof(IService))
                .AutoActivate();


            // Static method
            builder.Register<ICalendar>(x => StaticCalendar.CreateInstance()).AutoActivate();

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