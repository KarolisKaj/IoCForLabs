using IoCAttributes.Interfaces;
using Microsoft.Practices.Unity;

namespace IoCAttributes.Dependencies
{
    public class MainService : IService
    {
        [InjectionConstructor]
        public MainService()
        {

        }
    }
}
