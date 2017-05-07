namespace IoCUnity
{
    using Microsoft.Practices.Unity;
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Reflection;

    public class UnityAttributes
    {
        public void Compose()
        {
            IUnityContainer container = new UnityContainer();
            container.RegisterTypes(
                AllClasses.FromAssemblies(Assembly.LoadFrom(@"IoCAttributes.dll")),
                WithMappings.FromAllInterfaces,
                getLifetimeManager: (type) => WithLifetime.ContainerControlled(type));

            container.Registrations.Print();
            Console.Read();
        }
    }

    public static class Helper
    {
        public static void Print(this IEnumerable<ContainerRegistration> printables)
        {
            Console.WriteLine($"//--------------Container start------------{Environment.NewLine}");
            foreach (var part in printables)
                Console.WriteLine($"{part?.Name ?? "<No Name>"}, {part?.MappedToType}, {part?.RegisteredType}");
            Console.WriteLine($"{Environment.NewLine}//--------------Container end------------");
        }

        public static TValue GetAttributeValue<TAttribute, TValue>(
            this Type type,
            Func<TAttribute, TValue> valueSelector)
            where TAttribute : Attribute
        {
            var att = type.GetCustomAttributes(
                typeof(TAttribute), true
            ).FirstOrDefault() as TAttribute;
            if (att != null)
            {
                return valueSelector(att);
            }
            return default(TValue);
        }
    }
}
