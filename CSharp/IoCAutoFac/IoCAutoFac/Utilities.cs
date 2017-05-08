using Autofac;
using System;

namespace IoCAutoFac
{
    public static class Utilities
    {
        public static void Print(this IContainer container)
        {

            Console.WriteLine("////////CONTAINER PARTS///////////");
            Console.WriteLine();
            foreach (var registration in container.ComponentRegistry.Registrations)
            {
                Console.WriteLine($"{String.Join(", ", registration.Services)},  {registration.Target.Activator}");
            }
            Console.WriteLine();
            Console.WriteLine("////////CONTAINER PARTS///////////");
        }
    }
}
