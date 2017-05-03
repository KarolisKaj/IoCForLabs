namespace IoCUnity
{
    using Microsoft.Practices.Unity;
    using System.Linq;

    public class UnityAttributes
    {
        public void Start()
        {
            IUnityContainer myContainer = new UnityContainer();
            myContainer.RegisterTypes(AllClasses.FromLoadedAssemblies().Where(x => x.Assembly.FullName.Contains("IoCAttributes")));
        }
    }
}
