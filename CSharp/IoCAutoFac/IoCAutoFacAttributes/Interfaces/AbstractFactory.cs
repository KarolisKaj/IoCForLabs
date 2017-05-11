namespace IoCAutoFacAttributes.Interfaces
{
    using System;
    public abstract class AbstractFactory<T>
    {
        public abstract T GetObject { get; }

        public virtual bool IsSingleton { get { return true; } }

        public virtual Type ObjectType { get { return typeof(T); } }
    }
}
