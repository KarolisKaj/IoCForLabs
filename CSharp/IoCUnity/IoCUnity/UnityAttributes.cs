namespace IoCUnity
{
    using IoCAttributes.Dependencies;
    using IoCAttributes.Interfaces;
    using Microsoft.Practices.Unity;
    using System.Reflection;

    public class UnityAttributes
    {
        public void Compose()
        {
            IUnityContainer container = new UnityContainer();
            container.RegisterTypes(Assembly.LoadFrom(@"IoCAttributes.dll").GetTypes());
            //container.RegisterTypes(AllClasses.FromLoadedAssemblies().Where(x => x.Assembly.FullName.Contains("IoCAttributes")));
            foreach (var part in container.Registrations)
            {
                System.Console.WriteLine($"{part?.Name ?? "<No Name>"}, {part?.MappedToType}, {part?.RegisteredType}");
            }
            System.Console.Read();
        }
    }
}
