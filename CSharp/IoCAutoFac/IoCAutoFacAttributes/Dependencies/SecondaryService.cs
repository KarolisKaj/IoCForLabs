using IoCAutoFacAttributes.Interfaces;
using System;

namespace IoCAutoFacAttributes.Dependencies
{
    public class SecondaryService : IService, IDisposable, ICreationInterceptor
    {
        public void Dispose()
        {
            Console.WriteLine($"{this.ToString()} was disposed!");
        }

        public void Execute()
        {
            Console.WriteLine($"{this.ToString()} was initialized");
        }
    }
}
