using IoCAutoFacAttributes.Interfaces;
using System;

namespace IoCAutoFacAttributes.Dependencies
{
    public class ServiceFactory : AbstractFactory<IService>
    {
        public string Name { get; set; }

        public override IService GetObject => String.IsNullOrWhiteSpace(Name) ? (IService)new PrimaryService() : new PriceService(Name);

        public override bool IsSingleton => false;
    }
}
