using Autofac;
using Autofac.Core;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IoCAutoFac
{
    public static class Utilities
    {
        public static void Print(this IContainer container)
        {

            Console.WriteLine("////////CONTAINER PARTS///////////");
            foreach (var registration in container.ComponentRegistry.Registrations)
            {
                Console.WriteLine($"{String.Join(",", registration.Services)},  {registration.Target.Activator}, {registration.Id}");
            }
            Console.WriteLine("////////CONTAINER PARTS///////////");
        }
    }
}
