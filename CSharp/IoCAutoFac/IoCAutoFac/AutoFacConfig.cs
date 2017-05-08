using Autofac;
using IoCAutoFacAttributes.Dependencies;
using IoCAutoFacAttributes.Interfaces;
using System;

namespace IoCAutoFac
{
    public class AutoFacConfig
    {
        public void Compose()
        {
            var builder = new ContainerBuilder();
            // Request Scope
            builder.RegisterType<PrimaryService>().As<IService>().InstancePerRequest();
            builder.RegisterType<SecondaryService>().As<IService>().InstancePerLifetimeScope();


            var container = builder.Build();

            container.Print();

            Console.ReadLine();
        }
    }
}